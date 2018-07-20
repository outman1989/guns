/**
 * 初始化行情详情对话框
 */
var QuotationInfoDlg = {
    quotationInfoData : {}
};

/**
 * 清除数据
 */
QuotationInfoDlg.clearData = function() {
    this.quotationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QuotationInfoDlg.set = function(key, val) {
    this.quotationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QuotationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QuotationInfoDlg.close = function() {
    parent.layer.close(window.parent.Quotation.layerIndex);
}

/**
 * 收集数据
 */
QuotationInfoDlg.collectData = function() {
    this
    .set('id')
    .set('productCategory')
    .set('productVariety')
    .set('unitPrice')
    .set('province')
    .set('city')
    .set('area')
    .set('quotationDate');
}

/**
 * 提交添加
 */
QuotationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/quotation/add", function(data){
        Feng.success("添加成功!");
        window.parent.Quotation.table.refresh();
        QuotationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.quotationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QuotationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/quotation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Quotation.table.refresh();
        QuotationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.quotationInfoData);
    ajax.start();
}

$(function() {

});
