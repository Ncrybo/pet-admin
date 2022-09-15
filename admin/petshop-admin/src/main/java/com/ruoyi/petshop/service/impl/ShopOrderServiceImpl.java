package com.ruoyi.petshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.petshop.mapper.ShopOrderMapper;
import com.ruoyi.petshop.domain.ShopOrder;
import com.ruoyi.petshop.service.IShopOrderService;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService 
{
    @Autowired
    private ShopOrderMapper shopOrderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public ShopOrder selectShopOrderById(Long id)
    {
        return shopOrderMapper.selectShopOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param shopOrder 订单
     * @return 订单
     */
    @Override
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder)
    {
        return shopOrderMapper.selectShopOrderList(shopOrder);
    }

    /**
     * 新增订单
     * 
     * @param shopOrder 订单
     * @return 结果
     */
    @Override
    public int insertShopOrder(ShopOrder shopOrder)
    {
        return shopOrderMapper.insertShopOrder(shopOrder);
    }

    /**
     * 修改订单
     * 
     * @param shopOrder 订单
     * @return 结果
     */
    @Override
    public int updateShopOrder(ShopOrder shopOrder)
    {
        return shopOrderMapper.updateShopOrder(shopOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteShopOrderByIds(Long[] ids)
    {
        return shopOrderMapper.deleteShopOrderByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteShopOrderById(Long id)
    {
        return shopOrderMapper.deleteShopOrderById(id);
    }
}
