package com.stylefeng.guns.modular.trade.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.BussinessLog;
import com.stylefeng.guns.core.common.constant.dictmap.DeptDict;
import com.stylefeng.guns.core.common.constant.dictmap.QuotationDict;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.common.constant.state.BizLogType;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.model.OperationLog;
import com.stylefeng.guns.modular.system.warpper.LogWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Quotation;
import com.stylefeng.guns.modular.trade.service.IQuotationService;

import java.util.List;
import java.util.Map;

/**
 * 行情控制器
 *
 * @author fengshuonan
 * @Date 2018-07-16 17:58:17
 */
@Controller
@RequestMapping("/quotation")
public class QuotationController extends BaseController {

    private String PREFIX = "/trade/quotation/";

    @Autowired
    private IQuotationService quotationService;

    /**
     * 跳转到行情首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "quotation.html";
    }

    /**
     * 跳转到添加行情
     */
    @RequestMapping("/quotation_add")
    public String quotationAdd() {
        return PREFIX + "quotation_add.html";
    }

    /**
     * 跳转到修改行情
     */
    @RequestMapping("/quotation_update/{quotationId}")
    public String quotationUpdate(@PathVariable Integer quotationId, Model model) {
        Quotation quotation = quotationService.selectById(quotationId);
        model.addAttribute("item", quotation);
        LogObjectHolder.me().set(quotation);
        return PREFIX + "quotation_edit.html";
    }

    /**
     * 获取行情列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        EntityWrapper<Quotation> entityWrapper = new EntityWrapper<>();
        Wrapper<Quotation> wrapper = entityWrapper.like("product_variety", condition);
        Page<Quotation> page = new PageFactory<Quotation>().defaultPage();
        Page<Quotation> quotationPage = quotationService.selectPage(page, wrapper);
        return super.packForBT(quotationPage);
    }

    /**
     * 新增行情
     */
    @BussinessLog(value = "添加行情", key = "productCategory,productVariety,quotationDate", dict = QuotationDict.class)
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Quotation quotation) {
        quotationService.insert(quotation);
        return SUCCESS_TIP;
    }

    /**
     * 删除行情
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String quotationId) {
        quotationService.deleteById(quotationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改行情
     */
    @BussinessLog(value = "修改行情", key = "productCategory,productVariety,quotationDate", dict = QuotationDict.class)
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Quotation quotation) {
        quotationService.updateById(quotation);
        return SUCCESS_TIP;
    }

    /**
     * 行情详情
     */
    @RequestMapping(value = "/detail/{quotationId}")
    @ResponseBody
    public Object detail(@PathVariable("quotationId") Integer quotationId) {
        return quotationService.selectById(quotationId);
    }
}
