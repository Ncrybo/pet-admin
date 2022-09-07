package com.ruoyi.web.controller.petadmin;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.petshop.domain.ShopOrder;
import com.ruoyi.petshop.service.IShopOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * orderController
 *
 * @author ruoyi
 * @date 2022-09-07
 */
@RestController
@RequestMapping("/shop/order")
public class ShopOrderController extends BaseController
{
    @Autowired
    private IShopOrderService shopOrderService;

    /**
     * 查询order列表
     */
    @PreAuthorize("@ss.hasPermi('shop:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopOrder shopOrder)
    {
        startPage();
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        return getDataTable(list);
    }

    /**
     * 导出order列表
     */
    @PreAuthorize("@ss.hasPermi('shop:order:export')")
    @Log(title = "order", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopOrder shopOrder)
    {
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        ExcelUtil<ShopOrder> util = new ExcelUtil<ShopOrder>(ShopOrder.class);
        util.exportExcel(response, list, "order数据");
    }

    /**
     * 获取order详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(shopOrderService.selectShopOrderById(id));
    }

    /**
     * 新增order
     */
    @PreAuthorize("@ss.hasPermi('shop:order:add')")
    @Log(title = "order", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopOrder shopOrder)
    {
        return toAjax(shopOrderService.insertShopOrder(shopOrder));
    }

    /**
     * 修改order
     */
    @PreAuthorize("@ss.hasPermi('shop:order:edit')")
    @Log(title = "order", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopOrder shopOrder)
    {
        return toAjax(shopOrderService.updateShopOrder(shopOrder));
    }

    /**
     * 删除order
     */
    @PreAuthorize("@ss.hasPermi('shop:order:remove')")
    @Log(title = "order", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(shopOrderService.deleteShopOrderByIds(ids));
    }
}
