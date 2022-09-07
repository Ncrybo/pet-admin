package com.ruoyi.petshop.mapper;

import java.util.List;
import com.ruoyi.petshop.domain.ShopOrder;

/**
 * orderMapper接口
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public interface ShopOrderMapper 
{
    /**
     * 查询order
     * 
     * @param id order主键
     * @return order
     */
    public ShopOrder selectShopOrderById(Long id);

    /**
     * 查询order列表
     * 
     * @param shopOrder order
     * @return order集合
     */
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder);

    /**
     * 新增order
     * 
     * @param shopOrder order
     * @return 结果
     */
    public int insertShopOrder(ShopOrder shopOrder);

    /**
     * 修改order
     * 
     * @param shopOrder order
     * @return 结果
     */
    public int updateShopOrder(ShopOrder shopOrder);

    /**
     * 删除order
     * 
     * @param id order主键
     * @return 结果
     */
    public int deleteShopOrderById(Long id);

    /**
     * 批量删除order
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopOrderByIds(Long[] ids);
}
