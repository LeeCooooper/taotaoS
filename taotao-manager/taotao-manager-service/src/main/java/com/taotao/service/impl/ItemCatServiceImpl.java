package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.ItemCat;
import com.taotao.pojo.ItemCatResult;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.ZtreeResult;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<ZtreeResult> getZtreeResult(Long id) {
        List<TbItemCat> tbItemCats = tbItemCatMapper.findTbItemCatByParentId(id);
        List<ZtreeResult> results = new ArrayList<ZtreeResult>();
        for (TbItemCat tbItemCat: tbItemCats){
            ZtreeResult result = new ZtreeResult();
            result.setId(tbItemCat.getId());
            result.setName(tbItemCat.getName());
            result.setIsParent(tbItemCat.getIsParent());
            results.add(result);
        }
        return results;
    }

    @Override
    public ItemCatResult getItemCats() {
        ItemCatResult result = new ItemCatResult();
        result.setData(getItemCatList(0L));
        return result;
    }
    private List<?> getItemCatList(Long parentId){
        int count = 0;
        List list = new ArrayList();
        List<TbItemCat> tbItemCats = tbItemCatMapper.findTbItemCatByParentId(parentId);
        for (TbItemCat itemCat: tbItemCats) {
            ItemCat item = new ItemCat();
            if(itemCat.getIsParent()){
                item.setUrl("/products" + itemCat.getId() + ".html");
                if(itemCat.getParentId()==0){
                    //第一级
                    item.setName("<a href='/products/" + itemCat.getId() + ".html' >" + itemCat.getName() + "</a>");
                }else {
                    //第二级
                    item.setName(itemCat.getName());
                }
                item.setItems(getItemCatList(itemCat.getId()));
                list.add(item);
                count++;
                if(count >= 14 && parentId == 0){
                    break;
                }
            }else {
                //第三级
                list.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
            }
        }
        return list;
    }
}
