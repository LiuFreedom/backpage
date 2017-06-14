package com.kelan.animalsystem.httptools;

import com.kelan.animalsystem.encode.EncodeUtil;
import com.kelan.animalsystem.view.application.MyApplication;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HeaderWebService {

    private static String nameSpace = "http://service.webservice.sf.net/";
    public static String serverIp ="221.182.229.26:8080"; //"221.182.229.26:8080";//192.168.0.113:8080";// baiqtjh.wicp.net//

    public static Map<String, String> methodMap = new HashMap<String, String>() {
        {
            put("login", "http://" + serverIp +
                    "/dzcz/webservice/login?wsdl");

            put("getValidationCode", "http://" + serverIp +
                    "/dzcz/webservice/login?wsdl");//获取验证码的接口

            put("getAppVerson", "http://" + serverIp +
                    "/dzcz/webservice/login?wsdl");//获取版本更新信息

            put("getPushInfo", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//消息推送的接口

            put("anJianList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");

            put("listUserByRoleGroup", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//获取执法人列表

            put("saveApplyCase", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//保存权限申请

            put("listApplyCase", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//获取权限列表

            put("deleteApplyCase", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//删除为权限AuditingApplyCase

            put("AuditingApplyCase", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//执法人通过或驳回权限申请

            put("saveAnJian", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//添加案件

            put("deleteAnJian", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//删除案件

            put("listAnjainDoc", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");//案件的文书列表


            put("getUserInfo", "http://" + serverIp
                    + "/dzcz/webservice/Users?wsdl");

            put("listGroup", "http://" + serverIp
                    + "/dzcz/webservice/Users?wsdl");
            put("saveUser", "http://" + serverIp
                    + "/dzcz/webservice/Users?wsdl");

            //单个文书审批的接口
            put("establishedParty", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//行政处罚立案审批 通过
            put("refutedParty", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//行政处罚立案审批 驳回

            put("establishedCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//现场检查笔录 通过
            put("refutedCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//现场检查笔录 驳回

            put("establishedRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//询问笔录 通过
            put("refutedRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//询问笔录 驳回

            put("establishedEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//证据登记实 通过
            put("refutedEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//证据登记实 驳回

            put("establishedSampleEvidence", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//抽样取证凭证 通过
            put("refutedSampleEvidence", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//抽样取证凭证 驳回
            //以上立案

            put("establishedSuggestion", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//案件处理意见 通过
            put("refutedSuggestion", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//案件处理意见 驳回

            put("establishedNotification", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//行政处罚事先告知书 通过
            put("refutedNotification", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//行政处罚事先告知书 驳回

            put("establishedProofOfService", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//送达回证 通过
            put("refutedProofOfService", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//送达回证 驳回

            put("establishedSeizureDecision", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//查封(扣押)决定书 通过
            put("refutedSeizureDecision", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//查封(扣押)决定书 驳回

            put("establishedUnlockDecision", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//解除查封(扣押)决定书 通过
            put("refutedUnlockDecision", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//解除查封(扣押)决定书 驳回

            put("establishedSeizureRecord", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//查封（扣押）现场笔录 通过
            put("refutedSeizureRecord", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//查封（扣押）现场笔录 驳回

            put("establishedLockGoods", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//解除查封(扣押)财物清单 通过
            put("refutedLockGoods", "http://" + serverIp
                    + "/dzcz/webservice/casetreated?wsdl");//解除查封(扣押)财物清单 驳回
            //以上是处理过程

            put("establishedApprove", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚决定审批表 通过
            put("refutedApprove", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚决定审批表 驳回

            put("establishedResolved", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚决定书 通过
            put("refutedResolved", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚决定书 驳回

            put("establishedHearingNotice", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚听证会通知书 通过
            put("refutedHearingNotice", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚听证会通知书 驳回

            put("establishedHearingRecord", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚听证会记录 通过
            put("refutedHearingRecord", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚听证会记录 驳回

            put("establishedHearingReport", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚听证会报告书 通过
            put("refutedHearingReport", "http://" + serverIp
                    + "/dzcz/webservice/penalized?wsdl");//行政处罚听证会报告书 驳回
            //以上是审批阶段

            put("establishedCaseEndRecord", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//行政处罚结案报告 通过
            put("refutedCaseEndRecord", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//行政处罚结案报告 驳回

            put("establishedProcessingNotice", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//登记物品保存处理通知书 通过
            put("refutedProcessingNotice", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//登记物品保存处理通知书 驳回

            put("establishedEnforceApplication", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//强制执行申请书 通过
            put("refutedEnforceApplication", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//强制执行申请书 驳回

            put("establishedExigentNotice", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//行政处罚决定催告书 通过
            put("refutedCaseExigentNotice", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//行政处罚决定催告书 驳回

            put("establishedCaseTransfer", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//案件移送函 通过
            put("refutedCaseTransfer", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//案件移送函 驳回

            put("establishedGoodsDeal", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//罚没物品处理记录 通过
            put("refutedGoodsDeal", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//罚没物品处理记录 驳回

            put("establishedCorrectionNotice", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//责令改正通知书 通过
            put("refutedCorrectionNotice", "http://" + serverIp
                    + "/dzcz/webservice/caseend?wsdl");//责令改正通知书 驳回


            //WWWWWWWWWWWWWWWWWWWWWWWWW

            put("checkInstructionsList", "http://" + serverIp// 审核日记
                    + "/dzcz/webservice/executelaw?wsdl");

            put("saveApprovalForm", "http://" + serverIp // 行政处罚立案审批表
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("deleteApprovalForm", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("listApprovalForm", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("loadApprovalForm", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");


            put("saveCheckRecord", "http://" + serverIp // 现场检查笔录
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("deleteCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("listCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("loadCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");


            put("saveRecordQuestion", "http://" + serverIp// 询问笔录
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("listRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("deleteRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("loadRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");


            put("saveResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");
            put("deleteResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");
            put("listResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");
            put("loadResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");


            put("saveApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");
            put("deleteApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");
            put("listApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");
            put("loadApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");


            put("saveCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");
            put("deleteCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");
            put("listCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");
            put("loadCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");


            put("saveSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("deleteSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("listSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("loadSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");


            put("saveProofOfService", "http://" + serverIp // 送达回证
                    + "/dzcz/webservice/casetreated?wsdl");
            put("deleteProofOfService", "http://" + serverIp //
                    + "/dzcz/webservice/casetreated?wsdl");
            put("listProofOfService", "http://" + serverIp //
                    + "/dzcz/webservice/casetreated?wsdl");
            put("loadProofOfService", "http://" + serverIp //
                    + "/dzcz/webservice/casetreated?wsdl");


            put("saveNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("deleteNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("listNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("loadNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("saveSeizureRecord", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("deleteSeizureRecord", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("listSeizureRecord", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("loadSeizureRecord", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
//casetrated  第二阶段


            put("saveParty", "http://" + serverIp //立案审批表
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("deleteParty", "http://" + serverIp //
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("listParty", "http://" + serverIp //
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("loadParty", "http://" + serverIp //
                    + "/dzcz/webservice/putonrecord?wsdl");


            put("UploadFileBase64", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");
            put("listAttachment", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");
            put("saveFileBase64", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");
            put("deleteAttachment", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");

            put("deleteLocalPhoto", "http://" + serverIp //删除一张图片
                    + "/dzcz/webservice/fileprogress?wsdl");


            put("caseSubmit", "http://" + serverIp // 案件提交
                    + "/dzcz/webservice/executelaw?wsdl");


            put("caseChecked", "http://" + serverIp // 案件审核
                    + "/dzcz/webservice/executelaw?wsdl");

            put("caseUnChecked", "http://" + serverIp // 案件驳回
                    + "/dzcz/webservice/executelaw?wsdl");


            put("listSampleEvidence", "http://" + serverIp // 抽样取证凭证获取列表
                    + "/dzcz/webservice/putonrecord?wsdl");


            put("saveSampleEvidence", "http://" + serverIp // 保存
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("deleteSampleEvidence", "http://" + serverIp // 删除
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("loadSampleEvidence", "http://" + serverIp // 加载
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("listCaseTransfer", "http://" + serverIp // 案件移送函列表
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveCaseTransfer", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");

            put("deleteCaseTransfer", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");

            put("loadCaseTransfer", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listGoodsDeal", "http://" + serverIp // 罚没物品
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveGoodsDeal", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");

            put("deleteGoodsDeal", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");

            put("loadGoodsDeal", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listExigentNotice", "http://" + serverIp // 行政处罚决定催告书
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveExigentNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");

            put("deleteExigentNotice", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");

            put("loadExigentNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listEnforceApplication", "http://" + serverIp // 强制执行申请书列表
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveEnforceApplication", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");

            put("deleteEnforceApplication", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");

            put("loadEnforceApplication", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listProcessingNotice", "http://" + serverIp // 登记物品保存处理通知书
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveProcessingNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");

            put("deleteProcessingNotice", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");

            put("loadProcessingNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listCorrectionNotice", "http://" + serverIp // 责令改正通知书
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveCorrectionNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");

            put("deleteCorrectionNotice", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");

            put("loadCorrectionNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listUnlockDecision", "http://" + serverIp // 解除查封(扣押)决定书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("saveUnlockDecision", "http://" + serverIp // 保存
                    + "/dzcz/webservice/casetreated?wsdl");

            put("deleteUnlockDecision", "http://" + serverIp // 删除
                    + "/dzcz/webservice/casetreated?wsdl");

            put("loadUnlockDecision", "http://" + serverIp // 加载
                    + "/dzcz/webservice/casetreated?wsdl");

            put("listHearingRecord", "http://" + serverIp // 行政处罚听证会笔录
                    + "/dzcz/webservice/penalized?wsdl");

            put("saveHearingRecord", "http://" + serverIp // 保存
                    + "/dzcz/webservice/penalized?wsdl");

            put("deleteHearingRecord", "http://" + serverIp // 删除
                    + "/dzcz/webservice/penalized?wsdl");

            put("loadHearingRecord", "http://" + serverIp // 加载
                    + "/dzcz/webservice/penalized?wsdl");

            put("listHearingNotice", "http://" + serverIp // 行政处罚听证会通知书
                    + "/dzcz/webservice/penalized?wsdl");

            put("saveHearingNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/penalized?wsdl");

            put("deleteHearingNotice", "http://" + serverIp // 删除
                    + "/dzcz/webservice/penalized?wsdl");

            put("loadHearingNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/penalized?wsdl");

            put("listHearingReport", "http://" + serverIp // 行政处罚听证会报告书
                    + "/dzcz/webservice/penalized?wsdl");

            put("saveHearingReport", "http://" + serverIp // 保存
                    + "/dzcz/webservice/penalized?wsdl");

            put("deleteHearingReport", "http://" + serverIp // 删除
                    + "/dzcz/webservice/penalized?wsdl");

            put("loadHearingReport", "http://" + serverIp // 加载
                    + "/dzcz/webservice/penalized?wsdl");

            put("listSeizureDecision", "http://" + serverIp // 查封(扣押)决定书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("saveSeizureDecision", "http://" + serverIp // 保存
                    + "/dzcz/webservice/casetreated?wsdl");

            put("deleteSeizureDecision", "http://" + serverIp // 删除
                    + "/dzcz/webservice/casetreated?wsdl");

            put("loadSeizureDecision", "http://" + serverIp // 加载
                    + "/dzcz/webservice/casetreated?wsdl");

            put("listEvidenceRegister", "http://" + serverIp// 证据保存
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("saveEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("deleteEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("loadEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("penalizedList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");// 执行接口
            put("putOnRecordList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");// 立案接口
            put("treatedList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");// 处理接口

            put("listExamOnline", "http://" + serverIp// 考试
                    + "/dzcz/webservice/exam?wsdl");
            put("startExamOnline", "http://" + serverIp
                    + "/dzcz/webservice/exam?wsdl");
            put("loadExamOnline", "http://" + serverIp
                    + "/dzcz/webservice/exam?wsdl");
            put("saveExamOnline", "http://" + serverIp
                    + "/dzcz/webservice/exam?wsdl");

            put("listUserByRoleGroup", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");


            //在线视频
            put("listChannel", "http://" + serverIp
                    + "/dzcz/webservice/distancelearning?wsdl");

            //WWWWWWWWWWWWWWWWWWWWWWWWWWW


            put("checkInstructionsList", "http://" + serverIp// 审核日记
                    + "/dzcz/webservice/executelaw?wsdl");

            put("saveparty", "ht tp://" + serverIp // 行政处罚立案审批表
                    + "/dzcz/webservice/putonrecord?wsdl");

            //song lian
            put("deleteParty", "http://" + serverIp //删除行政处罚立案审批表
                    + "/dzcz/webservice/putonrecord?wsdl");

//            put("deleteApprovalForm", "http://" + serverIp
//                    + "/dzcz/webservice/putonrecord?wsdl");//删除行政处罚立案审批表


            put("listApprovalForm", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("loadApprovalForm", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("saveCheckRecord", "http://" + serverIp // 现场检查笔录
                    + "/dzcz/webservice/putonrecord?wsdl");

            //song lian
            put("deleteCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//删除现场检查笔录


            put("listCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("loadCheckRecord", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("saveRecordQuestion", "http://" + serverIp// 询问笔录
                    + "/dzcz/webservice/putonrecord?wsdl");
            put("listRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");


            //song lian
            put("deleteRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//删除问询笔录


            put("loadRecordQuestion", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("saveResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");


            put("deleteResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");


            put("listResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");
            put("loadResolved", "http://" + serverIp // 行政处罚决定书表
                    + "/dzcz/webservice/penalized?wsdl");

            put("saveApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");


            put("deleteApprove", "http://" + serverIp //删除 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");


            put("deleteHearingNotice", "http://" + serverIp //删除 行政处罚听证会通知书
                    + "/dzcz/webservice/penalized?wsdl");

            put("deleteHearingRecord", "http://" + serverIp // 删除 行政处罚听证会笔录
                    + "/dzcz/webservice/penalized?wsdl");

            put("deleteHearingReport", "http://" + serverIp // 删除 行政处罚听证会报告书
                    + "/dzcz/webservice/penalized?wsdl");


            put("listApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");
            put("loadApprove", "http://" + serverIp // 行政处罚决定审批表
                    + "/dzcz/webservice/penalized?wsdl");

            put("saveCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");


            put("listCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");
            put("loadCaseEndRecord", "http://" + serverIp // 行政处罚结案报告
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");


            //song chuli
            put("deleteSuggestion", "http://" + serverIp // 删除案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");


            put("listSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("loadSuggestion", "http://" + serverIp // 案件处理意见书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("saveNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");


            //song chuli
            put("deleteNotification", "http://" + serverIp // 删除行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            //song chuli
            put("deleteProofOfService", "http://" + serverIp // 删除送达回正
                    + "/dzcz/webservice/casetreated?wsdl");

            //song chuli
            put("deleteSeizureRecord", "http://" + serverIp // 删除查封（扣押）现场笔录
                    + "/dzcz/webservice/casetreated?wsdl");


            put("listNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");
            put("loadNotification", "http://" + serverIp // 行政处罚事先告知书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("UploadFileBase64", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");
            put("listAttachment", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");
            put("saveFileBase64", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");
            put("deleteAttachment", "http://" + serverIp // 文件上传
                    + "/dzcz/webservice/fileprogress?wsdl");

            put("deleteLocalPhoto", "http://" + serverIp //删除一张图片
                    + "/dzcz/webservice/fileprogress?wsdl");

            put("saveLocalPhoto", "http://" + serverIp //上传图片
                    + "/dzcz/webservice/fileprogress?wsdl");


            put("caseSubmit", "http://" + serverIp // 案件提交
                    + "/dzcz/webservice/executelaw?wsdl");

            put("caseChecked", "http://" + serverIp // 案件审核
                    + "/dzcz/webservice/executelaw?wsdl");

            put("caseUnChecked", "http://" + serverIp // 案件驳回
                    + "/dzcz/webservice/executelaw?wsdl");


            put("listSampleEvidence", "http://" + serverIp // 抽样取证凭证获取列表
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("saveSampleEvidence", "http://" + serverIp // 保存
                    + "/dzcz/webservice/putonrecord?wsdl");


            //song lian
            put("deleteSampleEvidence", "http://" + serverIp // 删除抽样取证凭证
                    + "/dzcz/webservice/putonrecord?wsdl");


            put("loadSampleEvidence", "http://" + serverIp // 加载
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("listCaseTransfer", "http://" + serverIp // 案件移送函列表
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveCaseTransfer", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteCaseTransfer", "http://" + serverIp // 删除 案件移送函列表
                    + "/dzcz/webservice/caseend?wsdl");


            put("loadCaseTransfer", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listGoodsDeal", "http://" + serverIp // 罚没物品
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveGoodsDeal", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteGoodsDeal", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");


            put("loadGoodsDeal", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listExigentNotice", "http://" + serverIp // 行政处罚决定催告书
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveExigentNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteExigentNotice", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");


            put("loadExigentNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listEnforceApplication", "http://" + serverIp // 强制执行申请书列表
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveEnforceApplication", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteEnforceApplication", "http://" + serverIp // 删除强制执行申请书列表
                    + "/dzcz/webservice/caseend?wsdl");


            put("loadEnforceApplication", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listProcessingNotice", "http://" + serverIp // 登记物品保存处理通知书
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveProcessingNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteProcessingNotice", "http://" + serverIp // 删除
                    + "/dzcz/webservice/caseend?wsdl");


            put("loadProcessingNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listCorrectionNotice", "http://" + serverIp // 责令改正通知书
                    + "/dzcz/webservice/caseend?wsdl");

            put("saveCorrectionNotice", "http://" + serverIp // 保存
                    + "/dzcz/webservice/caseend?wsdl");


            put("deleteCorrectionNotice", "http://" + serverIp // 删除 责令改正通知书
                    + "/dzcz/webservice/caseend?wsdl");


            put("loadCorrectionNotice", "http://" + serverIp // 加载
                    + "/dzcz/webservice/caseend?wsdl");

            put("listUnlockDecision", "http://" + serverIp // 解除查封(扣押)决定书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("saveUnlockDecision", "http://" + serverIp // 保存
                    + "/dzcz/webservice/casetreated?wsdl");

            //song chuli
            put("deleteUnlockDecision", "http://" + serverIp // 删除 解除查封(扣押)决定书
                    + "/dzcz/webservice/casetreated?wsdl");
            //song chuli
            put("deleteLockGoods", "http://" + serverIp // 删除 解除查封(扣押)财物清单
                    + "/dzcz/webservice/casetreated?wsdl");

            put("loadUnlockDecision", "http://" + serverIp // 加载
                    + "/dzcz/webservice/casetreated?wsdl");

            put("listSeizureDecision", "http://" + serverIp // 查封(扣押)决定书
                    + "/dzcz/webservice/casetreated?wsdl");

            put("saveSeizureDecision", "http://" + serverIp // 保存
                    + "/dzcz/webservice/casetreated?wsdl");

            //song chili
            put("deleteSeizureDecision", "http://" + serverIp // 删除
                    + "/dzcz/webservice/casetreated?wsdl");

            put("loadSeizureDecision", "http://" + serverIp // 加载
                    + "/dzcz/webservice/casetreated?wsdl");


            put("listEvidenceRegister", "http://" + serverIp// 证据保存
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("saveEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");


            //song lian
            put("deleteEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");//证据登记保存清单


            put("loadEvidenceRegister", "http://" + serverIp
                    + "/dzcz/webservice/putonrecord?wsdl");

            put("penalizedList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");// 执行接口
            put("putOnRecordList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");// 立案接口
            put("treatedList", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");// 处理接口

            put("listExamOnline", "http://" + serverIp// 考试
                    + "/dzcz/webservice/exam?wsdl");
            put("startExamOnline", "http://" + serverIp
                    + "/dzcz/webservice/exam?wsdl");
            put("loadExamOnline", "http://" + serverIp
                    + "/dzcz/webservice/exam?wsdl");
            put("saveExamOnline", "http://" + serverIp
                    + "/dzcz/webservice/exam?wsdl");

            put("listUserByRoleGroup", "http://" + serverIp
                    + "/dzcz/webservice/executelaw?wsdl");

            //在线视频
            put("listChannel", "http://" + serverIp
                    + "/dzcz/webservice/distancelearning?wsdl");

            //检疫模块
            //检疫处理通知单
            put("saveNoticeOfDisposition", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存检疫处理通知书

            put("listNoticeOfDisposition", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取检疫处理通知书列表

            put("loadNoticeOfDisposition", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载检疫处理通知书，还没有用


            put("listRegulations", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取法律列表数据的接口

            put("saveNoticeOfDisposition", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存入场检疫通知书

            put("listButcherApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取检疫申报书（屠宰）listProductApplyRecord

            put("listProductApplyRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取检疫申报书（产地）

            put("listApplyRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取检疫受理列表

            put("saveAcceptApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存受理

            put("listQuarantineApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取合格证的列表
            put("listQuarantineApplyed", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取合格证的列表(yichuz )

            put("saveQuarantine", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存合格证的列表

            put("cancelQuarantine", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//作废合格证的列表

            put("listNoticing", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//异常检疫记录列表listNoticed

            put("listNoticed", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//通知书列表

            put("listQuarantineApplyRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// a)获取检疫申报检疫列表

            put("saveButcherRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// a)保存屠宰检疫报告

            put("listQuarantineNotes", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// a)获取屠宰检疫记录列表

            put("saveProducedRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// a保存产地检疫报告

            //入场检疫
            put("saveAdmissionCert", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存入场检疫单

            put("listAdmissionCert", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取入场合格证检疫列表

            put("listRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取入场后的数据列表


            put("listUserByGroup", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取监管人下拉列表数据 2017-3-8

            put("listDictionaryByNum", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取数字字典

            put("loadViewOfScene", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载入场检查表

//            put("loadQuarantineCertificateByNO", "http://" + serverIp
//                    + "/dzcz/webservice/quarantine?wsdl");//通过合格证编号查合格证信息

             put("getCertificateCert", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//通过合格证编号查合格证信息

            put("listButcherCert", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载屠宰检疫申报列表记录

            put("loadApplyCert", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载检疫记录

            put("listOtherProvince", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载省外证明

            put("listLocalProvince", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载省内证明

            put("listQuarantineNotes", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// a)获取修改记录列表


            //检疫申报
//            put("listQuarantineApply", "http://" + serverIp
//                    + "/dzcz/webservice/quarantine?wsdl");//获取检疫申报列表

            put("loadQuarantineApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//加载检疫申报书saveQuarantineApply

            put("saveProductApplyRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存产地检疫申报书

            put("saveApplyCert", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存屠宰检疫申报书

            put("checkQuarantineApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//提交检疫申报书

            put("listButcherApplyRecord", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取屠宰申报后的列表

            put("loadViewOfSceneByBox", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//根据入场的信息加载入场查验数据


            //检疫受理
            put("saveAcceptanceOperation", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存检疫受理列表


            put("listQuarantineCertificate", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//合格证列表A,B,A,B

            //分销申请
            put("saveDistributionApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//保存分销申请
            put("loadDistributionApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取分销申请
            put("checkDistributionApply", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//审核分销申请

            //远程视屏监控
            put("listMonitor", "http://" + serverIp
                    + "/dzcz/webservice/monitor?wsdl");//获取远程视屏监控的列表数据

            //获取下拉列表的数据
            put("listCombox", "http://" + serverIp
                    + "/dzcz/webservice/combox?wsdl");//获取下拉列表的数据
            //获取省市下拉列表的数据
            put("getChildAreas", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取省，市，县的下拉列表的数据

            put("listDictionaryByNum", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");//获取数字字典


            //跨省调运
            put("saveDeclareInformation", "http://" + serverIp     // 引入申请保存
                    + "/dzcz/webservice/declare?wsdl");

            put("saveMessageFeedback", "http://" + serverIp     // 信息反馈保存
                    + "/dzcz/webservice/declare?wsdl");

            put("saveOutInsulaSupervise", "http://" + serverIp     // 出岛监管保存
                    + "/dzcz/webservice/declare?wsdl");

            put("saveDropPlaceSupervise", "http://" + serverIp     // 监督检查保存
                    + "/dzcz/webservice/declare?wsdl");

            put("savePortSupervise", "http://" + serverIp     // 口岸监管保存
                    + "/dzcz/webservice/declare?wsdl");

            put("loadQuarantineCertificateByNO", "http://" + serverIp     // 加载检疫证
                    + "/dzcz/webservice/quarantine?wsdl");

            put("saveAnswerBookFast", "http://" + serverIp     // 快速出答复书保存
                    + "/dzcz/webservice/declare?wsdl");

            put("saveAnswerBook", "http://" + serverIp     // 保存答复书
                    + "/dzcz/webservice/declare?wsdl");

            put("saveApprovalFroms", "http://" + serverIp     // 保存审批表
                    + "/dzcz/webservice/declare?wsdl");

            put("listDeclareInformation", "http://" + serverIp     // 引入申请列表
                    + "/dzcz/webservice/declare?wsdl");

            put("checkListDeclareInformation", "http://" + serverIp     // 引入审核列表
                    + "/dzcz/webservice/declare?wsdl");

            put("listAllApprovalTable", "http://" + serverIp     // 引入审核列表
                    + "/dzcz/webservice/declare?wsdl");

            put("listOutInsulaSupervise", "http://" + serverIp     // 出岛监管列表
                    + "/dzcz/webservice/declare?wsdl");

            put("deleteDeclareInformation", "http://" + serverIp              // 引入申请删除
                    + "/dzcz/webservice/declare?wsdl");

            put("deleteOutInsulaSupervise", "http://" + serverIp              // 出岛监管删除
                    + "/dzcz/webservice/declare?wsdl");

            put("loadDeclareInformation", "http://" + serverIp              // 引入申请加载
                    + "/dzcz/webservice/declare?wsdl");

            put("loadApprovalFroms", "http://" + serverIp              // 审批表加载
                    + "/dzcz/webservice/declare?wsdl");

            put("loadPortSupervise", "http://" + serverIp              // 落地监管加载
                    + "/dzcz/webservice/declare?wsdl");

            put("listPortSuperviseBatch", "http://" + serverIp              // 落地监管加载
                    + "/dzcz/webservice/declare?wsdl");

            put("listMaterial", "http://" + serverIp              // 引入申请图片列表加载
                    + "/dzcz/webservice/declare?wsdl");

            put("loadOutInsulaSupervise", "http://" + serverIp              // 出岛监管加载
                    + "/dzcz/webservice/declare?wsdl");

            put("listDropPlaceSupervise", "http://" + serverIp      // 落地监管加载2
                    + "/dzcz/webservice/declare?wsdl");

            put("loadAnswerBook", "http://" + serverIp      //加载答复书
                    + "/dzcz/webservice/declare?wsdl");

            put("checkDeclare", "http://" + serverIp              // 引入申请通过
                    + "/dzcz/webservice/declare?wsdl");

            put("unCheckDeclare", "http://" + serverIp              // 引入申请不通过
                    + "/dzcz/webservice/declare?wsdl");

            put("listAllAnswerBook", "http://" + serverIp              // 答复书列表
                    + "/dzcz/webservice/declare?wsdl");

            put("listAnswerBookInfo", "http://" + serverIp              // 所有答复书列表
                    + "/dzcz/webservice/declare?wsdl");

            put("listportSupervise", "http://" + serverIp              // 口岸监管列表
                    + "/dzcz/webservice/declare?wsdl");

            put("listQualifiedPass", "http://" + serverIp              // 落地监管列表
                    + "/dzcz/webservice/declare?wsdl");

            put("listCheckStopGroups", "http://" + serverIp              // 获取口岸
                    + "/dzcz/webservice/declare?wsdl");

            put("listCheckStopGroups", "http://" + serverIp              // 图片审核通过
                    + "/dzcz/webservice/declare?wsdl");

            put("qualified", "http://" + serverIp              // 图片审核不通过
                    + "/dzcz/webservice/declare?wsdl");

            put("unQualified", "http://" + serverIp              // 落地监管加载
                    + "/dzcz/webservice/declare?wsdl");

            put("listMessageRecordByABookId", "http://" + serverIp    // 查询口岸检查站合格并放行的物种信息列表
                    + "/dzcz/webservice/declare?wsdl");


            //证章模块申请
            put("saveApply", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// a)保存编辑票证申请数据

            put("loadSeizureDecision", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// b)加载票证申请数据

            put("listApply", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl"); //c)加载票证申请数据列表


            put("loadApply", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl"); //c)加载单挑信息

            put("deleteApply", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)删除票证申请数据

            put("uploadPhoto", "http://" + serverIp
                    + "/dzcz/webservice/fileprogress?wsdl");// d)图片上传

            put("listCombox", "http://" + serverIp
                    + "/dzcz/webservice/combox?wsdl");// d)下拉单位

            put("ticketInstock", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)入库

            put("applyAudit", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)审核

            put("ticketSend", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)发放


            put("listStock", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)f)获取库存号段列表


            put("listStockNoRange", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)fk)获取单位的某票证类型的库存号段列表


            put("listAuditAndSend", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)fk)获取单位的某票证类型的库存号段列表


            put("listProductor", "http://" + serverIp
                    + "/dzcz/webservice/Users?wsdl");// d)fk)获取获取制作厂商信息列表


            put("getMyAndChildGroups", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)fk)获取当前登录用户的单位及下属单位

            put("listProduct", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)fk)f)获取制作厂商的票证申请信息列表

            put("ticketProduct", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)j)票证申请制作

            put("listSendNoRange", "http://" + serverIp
                    + "/dzcz/webservice/ticket?wsdl");// d)j)l)获取票证发放的号段列表


            //养殖无害化养殖环节

            put("listHarmless", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");
            put("saveCultivationHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("listCultivationHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("updateFileForHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("listByTownData", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("listByCityData", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("loadCultivationHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("checkApplication", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("summarizingOperation", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("listForProvince", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("announcement", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("sumarizingReview", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("InfosReview", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");
            put("deleteFileForHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");





            //档案管理
            put("listArchives", "http://" + serverIp
                    + "/dzcz/webservice/archives?wsdl");
            put("saveArchivesForFolder", "http://" + serverIp
                    + "/dzcz/webservice/archives?wsdl");

            put("renameArchives", "http://" + serverIp
                    + "/dzcz/webservice/archives?wsdl");
            put("deleteArchives", "http://" + serverIp
                    + "/dzcz/webservice/archives?wsdl");
            put("updateFile", "http://" + serverIp
                    + "/dzcz/webservice/archives?wsdl");


            //屠宰无害化模块检疫通知单接口
            put("listNoticeOfDisposition", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// d)j)l)获取检疫通知单列表


            put("loadNoticeOfDisposition", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// d)j)l)加载单条检疫通知书

            put("updateFileForHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// d)j)l)现场监督上传附件

            //屠宰无害化模块申报单接口

            put("listButcherHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// 获取申报信息列表

            put("loadButcherHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");//根据无害化申报id获取申报信息

            put("loadButcherHarmlessByNotice", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// 根据处理通知书id获取申报信息

            put("saveButcherHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// a)保存申报信息
		    put("deleteFileForHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// a)删除现场监督相片

            //屠宰无害化模块补贴申报接口

            put("listFinancialApplication", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");//获取补贴申报信息列表


            put("loadFinancialApplication", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");//根据无害化财政补贴申报id获取补贴申报信息

            put("loadFinancialApplicationByHarmlessId", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");//根据无害化处理申报id获取补贴申报信息

            put("saveFinancialApplication", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// a)保存申报信息

            //屠宰无害化模块审核接口
            put("checkApplication", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// a)无害化模块审核接口
            put("listHarmless", "http://" + serverIp
                    + "/dzcz/webservice/quarantine?wsdl");// a)无害化列表
            put("deleteFileForHarmless", "http://" + serverIp
                    + "/dzcz/webservice/harmless?wsdl");// a)无害化列表




        }
    };

    public static String CallHeaderWebService(String method,
                                              Map<String, String> params) {

        String url = methodMap.get(method);
        System.out.println(url);
        // 创建HttpTransportSE对象，传递WebService服务器地址
        final HttpTransportSE httpTransportSE = new HttpTransportSE(url);
        // 创建SoapObject对象
        SoapObject soapObject = new SoapObject(nameSpace, method);

        // SoapObject添加参数
        if (params != null) {
            for (Iterator<Map.Entry<String, String>> it = params.entrySet()
                    .iterator(); it.hasNext(); ) {
                Map.Entry<String, String> entry = it.next();
                soapObject.addProperty(entry.getKey(), EncodeUtil.hashEncrypt(
                        entry.getValue(), EncodeUtil.secret));
            }
        }

        // 加入了Header
        Element[] header = new Element[1];

        if (method.equals("login")) {
            header[0] = new Element();
            header[0].setName("RequestSOAPHeader");
            Element username = new Element();
            // 添加第一个参数
            username.setName("spId");
            username.addChild(Node.TEXT, params.get("userId").toString());
            header[0].addChild(Node.ELEMENT, username);
            Element pass = new Element();
            // 添加第二个参数
            pass.setName("spPassword");
            pass.addChild(Node.TEXT, params.get("password").toString());
            header[0].addChild(Node.ELEMENT, pass);
            // 添加第三个参数
            Element code = new Element();
            code.setName("code");
            code.addChild(Node.TEXT, params.get("code").toString());
            header[0].addChild(Node.ELEMENT, code);

        } else if (method.equals("getValidationCode")||method.equals("getAppVerson")) {
            header[0] = new Element();
            header[0].setName("RequestSOAPHeader");
            Element username = new Element();
            // 添加第一个参数
            username.setName("spId");
            username.addChild(Node.TEXT, params.get("userId").toString());
            header[0].addChild(Node.ELEMENT, username);

            Element pass = new Element();
            // 添加第二个参数
            pass.setName("spPassword");
            pass.addChild(Node.TEXT, "ww");
            header[0].addChild(Node.ELEMENT, pass);
        } else {
            header[0] = new Element();
            header[0].setName("RequestSOAPHeader");
            Element token = new Element();

            // 添加第一个参数
            token.setName("token");
            token.addChild(Node.TEXT, MyApplication.getInstance().Token);
            header[0].addChild(Node.ELEMENT, token);

            Element ciphertext = new Element();
            long tokenTime1 = System.currentTimeMillis();
            long tokenTime2 = tokenTime1 - 3699;

            String cipher = "userId=" + MyApplication.getInstance().Username
                    + ";tokenTime=" + tokenTime2 + ";password="
                    + MyApplication.getInstance().Password;
            String cipher1 = EncodeUtil.Encrypt(cipher, "MD5");
            // 添加第二个参数
            ciphertext.setName("ciphertext");
            ciphertext.addChild(Node.TEXT, cipher1);
            header[0].addChild(Node.ELEMENT, ciphertext);
            // tokenTime 当前时间 - 3699
            Element tokenTime = new Element();
            // 添加第三个参数
            tokenTime.setName("tokenTime");
            tokenTime.addChild(Node.TEXT, String.valueOf(tokenTime1));
            header[0].addChild(Node.ELEMENT, tokenTime);
        }
        // 实例化SoapSerializationEnvelope，传入WebService的SOAP协议的版本号
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        System.out.println("这是一个标识-----------5");
        // 设置是否调用的是.Net开发的WebService
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = false;
        envelope.bodyOut = soapObject;
        envelope.headerOut = header;
        System.out.println("这是一个标识-----------6");
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(null, envelope);
            if (envelope != null) {
                SoapObject request = (SoapObject) envelope.bodyIn;
                String deta = request.getProperty(0).toString();
                String detail = EncodeUtil.hashDecrypt(deta, EncodeUtil.secret);
                // String detail = URLDecoder.decode(request.getProperty(0)
                // .toString(), "utf-8");
                return detail;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}