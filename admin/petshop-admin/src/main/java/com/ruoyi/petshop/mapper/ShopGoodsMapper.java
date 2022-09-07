package com.ruoyi.petshop.mapper;

import java.util.List;
import com.ruoyi.petshop.domain.ShopGoods;

/**
 * 商品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public interface ShopGoodsMapper 
{
    /**
     * 查询商品管理
     * 
     * @param id 商品管理主键
     * @return 商品管理
     */
    public ShopGoods selectShopGoodsById(Long id);

    /**
     * 查询商品管理列表
     * 
     * @param shopGoods 商品管理
     * @return 商品管理集合
     */
    public List<ShopGoods> selectShopGoodsList(ShopGoods shopGoods);

    /**
     * 新增商品管理
     * 
     * @param shopGoods 商品管理
     * @return 结果
     */
    public int insertShopGoods(ShopGoods shopGoods);

    /**
     * 修改商品管理
     * 
     * @param shopGoods 商品管理
     * @return 结果
     */
    public int updateShopGoods(ShopGoods shopGoods);

    /**
     * 删除商品管理
     * 
     * @param id 商品管理主键
     * @return 结果
     */
    public int deleteShopGoodsById(Long id);

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopGoodsByIds(Long[] ids);
}
