package com.stylefeng.guns.core.common.constant.dictmap;

import com.stylefeng.guns.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * 行情的映射
 *
 * @author lx
 * @date 2018-7-19 11:37:09
 */
public class QuotationDict extends AbstractDictMap {

    @Override
    public void init() {
        put("productCategory", "猪源品类");
        put("productVariety", "猪源品种");
        put("quotationDate", "行情日期");
        put("unitPrice", "价格");
        put("province", "所在省");
        put("city", "所在市");
        put("area", "所在区县");
    }

    @Override
    protected void initBeWrapped() {
    }
}
