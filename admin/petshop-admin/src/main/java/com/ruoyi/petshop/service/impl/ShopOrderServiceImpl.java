package com.ruoyi.petshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.petshop.mapper.ShopOrderMapper;
import com.ruoyi.petshop.domain.ShopOrder;
import com.ruoyi.petshop.service.IShopOrderService;

/**
 * orderService业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService 
{
    @Autowired
    private ShopOrderMapper shopOrderMapper;

    /**
     * 查询order
     * 
     * @param id order主键
     * @return order
     */
    @Override
    public ShopOrder selectShopOrderById(Long id)
    {
        return shopOrderMapper.selectShopOrderById(id);
    }

    /**
     * 查询order列表
     * 
     * @param shopOrder order
     * @return order
     */
    @Override
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder)
    {
        return shopOrderMapper.selectShopOrderList(shopOrder);
    }

    /**
     * 新增order
     * 
     * @param shopOrder order
     * @return 结果
     */
    @Override
    public int insertShopOrder(ShopOrder shopOrder)
    {
        return shopOrderMapper.insertShopOrder(shopOrder);
    }

    /**
     * 修改order
     * 
     * @param shopOrder order
     * @return 结果
     */
    @Override
    public int updateShopOrder(ShopOrder shopOrder)
    {
        return shopOrderMapper.updateShopOrder(shopOrder);
    }

    /**
     * 批量删除order
     * 
     * @param ids 需要删除的order主键
     * @return 结果
     */
    @Override
    public int deleteShopOrderByIds(Long[] ids)
    {
        return shopOrderMapper.deleteShopOrderByIds(ids);
    }

    /**
     * 删除order信息
     * 
     * @param id order主键
     * @return 结果
     */
    @Override
    public int deleteShopOrderById(Long id)
    {
        return shopOrderMapper.deleteShopOrderById(id);
    }
}
