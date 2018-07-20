package com.stylefeng.guns.modular.trade.service.impl;

import com.stylefeng.guns.modular.system.model.Quotation;
import com.stylefeng.guns.modular.system.dao.QuotationMapper;
import com.stylefeng.guns.modular.trade.service.IQuotationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 行情 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-07-16
 */
@Service
public class QuotationServiceImpl extends ServiceImpl<QuotationMapper, Quotation> implements IQuotationService {

}
