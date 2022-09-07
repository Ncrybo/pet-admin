package com.ruoyi.petshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.petshop.mapper.ShopGoodsMapper;
import com.ruoyi.petshop.domain.ShopGoods;
import com.ruoyi.petshop.service.IShopGoodsService;

/**
 * 商品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class ShopGoodsServiceImpl implements IShopGoodsService 
{
    @Autowired
    private ShopGoodsMapper shopGoodsMapper;

    /**
     * 查询商品管理
     * 
     * @param id 商品管理主键
     * @return 商品管理
     */
    @Override
    public ShopGoods selectShopGoodsById(Long id)
    {
        return shopGoodsMapper.selectShopGoodsById(id);
    }

    /**
     * 查询商品管理列表
     * 
     * @param shopGoods 商品管理
     * @return 商品管理
     */
    @Override
    public List<ShopGoods> selectShopGoodsList(ShopGoods shopGoods)
    {
        return shopGoodsMapper.selectShopGoodsList(shopGoods);
    }

    /**
     * 新增商品管理
     * 
     * @param shopGoods 商品管理
     * @return 结果
     */
    @Override
    public int insertShopGoods(ShopGoods shopGoods)
    {
        return shopGoodsMapper.insertShopGoods(shopGoods);
    }

    /**
     * 修改商品管理
     * 
     * @param shopGoods 商品管理
     * @return 结果
     */
    @Override
    public int updateShopGoods(ShopGoods shopGoods)
    {
        return shopGoodsMapper.updateShopGoods(shopGoods);
    }

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的商品管理主键
     * @return 结果
     */
    @Override
    public int deleteShopGoodsByIds(Long[] ids)
    {
        return shopGoodsMapper.deleteShopGoodsByIds(ids);
    }

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理主键
     * @return 结果
     */
    @Override
    public int deleteShopGoodsById(Long id)
    {
        return shopGoodsMapper.deleteShopGoodsById(id);
    }
}
