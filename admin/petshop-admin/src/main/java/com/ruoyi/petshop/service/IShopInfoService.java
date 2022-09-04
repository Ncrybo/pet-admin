package com.ruoyi.petshop.service;

import java.util.List;
import com.ruoyi.petshop.domain.ShopInfo;

/**
 * 商家信息增删改Service接口
 *
 * @author bobo
 * @date 2022-08-31
 */
public interface IShopInfoService
{
    /**
     * 查询商家信息增删改
     *
     * @param id 商家信息增删改主键
     * @return 商家信息增删改
     */
    public ShopInfo selectShopInfoById(Long id);

    /**
     * 查询商家信息增删改列表
     *
     * @param shopInfo 商家信息增删改
     * @return 商家信息增删改集合
     */
    public List<ShopInfo> selectShopInfoList(ShopInfo shopInfo);

    /**
     * 新增商家信息增删改
     *
     * @param shopInfo 商家信息增删改
     * @return 结果
     */
    public int insertShopInfo(ShopInfo shopInfo);

    /**
     * 修改商家信息增删改
     *
     * @param shopInfo 商家信息增删改
     * @return 结果
     */
    public int updateShopInfo(ShopInfo shopInfo);

    /**
     * 批量删除商家信息增删改
     *
     * @param ids 需要删除的商家信息增删改主键集合
     * @return 结果
     */
    public int deleteShopInfoByIds(Long[] ids);

    /**
     * 删除商家信息增删改信息
     *
     * @param id 商家信息增删改主键
     * @return 结果
     */
    public int deleteShopInfoById(Long id);
}
