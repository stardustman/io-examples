package io.github.stardustman.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import io.github.stardustman.excel.model.BugStatsInfo;
import io.github.stardustman.excel.model.ReportData;
import io.github.stardustman.excel.model.TaskInfo;
import io.github.stardustman.excel.util.TestFileUtil;
import io.github.stardustman.excel.model.BugRankInfo;

import java.util.ArrayList;
import java.util.List;


public class ExcelReportTest {
    public static void main(String[] args) {
        String userDir = TestFileUtil.getUserDir();
        String templateFile = userDir + "/src/main/代码安全报告.xlsx";
        String resultFile = userDir + "/src/main/代码安全报告42.xlsx";

        ExcelWriter excelWriter = EasyExcel.write(resultFile).withTemplate(templateFile).build();
        // sheet0 对应报表数据
        WriteSheet writeSheet0 = EasyExcel.writerSheet(0).build();
        FillConfig fillConfig = FillConfig.builder().build();
        excelWriter.fill(new FillWrapper("data",makeTaskInfo()),fillConfig,writeSheet0);
        excelWriter.fill(new FillWrapper("data1",makeBugRankInfo()),fillConfig,writeSheet0);
        excelWriter.fill(new FillWrapper("data3",makeBugStatsInfo()),fillConfig,writeSheet0);

        // sheet1 规整列表数据
        WriteSheet writeSheet1 = EasyExcel.writerSheet(1).build();
        excelWriter.fill(makeDataSheet2(),writeSheet1);

        excelWriter.finish();

    }

    private static List<BugStatsInfo> makeBugStatsInfo() {
        List<BugStatsInfo> bugStatsInfoList = new ArrayList<>();
        bugStatsInfoList.add(BugStatsInfo.builder().superTotal("40").superRatio("40%")
                .highTotal("10").highRatio("10%")
                .middleTotal("20").middleRatio("20%")
                .build());
        return bugStatsInfoList;
    }

    private static List<BugRankInfo> makeBugRankInfo() {
        List<BugRankInfo> bugRankInfoList = new ArrayList<>();
        bugRankInfoList.add(BugRankInfo.builder().bugName("bug1").bugTotal("10").bugRatio("10%").build());
        bugRankInfoList.add(BugRankInfo.builder().bugName("bug2").bugTotal("20").bugRatio("20%").build());
        bugRankInfoList.add(BugRankInfo.builder().bugName("bug3").bugTotal("30").bugRatio("30%").build());
        return bugRankInfoList;
    }

    private static List<ReportData> makeData() {
        List<ReportData> reportDataList = new ArrayList<>();
        reportDataList.add(ReportData.builder().orgName("阿里巴巴")
                .sysChi("宇宙第一测试系统")
                .sysEng("testSystem")
                .sysType("test")
                .versionLine("2022-11-24")
                .taskId("1234567876543")
                .taskFrom("自建")
                .mainDevLanguage("Rust")
                .taskName("宇宙第一测试系统-testSystem-自建")
                .bugId("8888888888888")
                .build()
        );
        return reportDataList;
    }


    private static List<TaskInfo> makeTaskInfo() {
        List<TaskInfo> reportDataList = new ArrayList<>();
        reportDataList.add(TaskInfo.builder().taskName("Test")
                .orgName("INFO")
                .sysChi("TestSys")
                .taskName("ABCD")
                .sysChi("宇宙第一测试系统")
                .sysEng("testSystem")
                .versionLine("2022-11-24")
                .mainDevLanguage("Rust")
                .orgFullName("Forty-Pirate Group")
                .taskCode("35628790")
                .build());
        return reportDataList;
    }



    private static List<ReportData> makeDataSheet2() {
        List<ReportData> reportDataList = new ArrayList<>();
        reportDataList.add(ReportData.builder()
                .sysChi("宇宙第一测试系统")
                .sysEng("testSystem")
                .bugId("123456789")
                .mainDevLanguage("R")
                .orgName("Alibaba")
                .sysType("APP")
                .taskFrom("GitHub")
                .versionLine("2023-01-04")
                .taskName("测试一号")
                .build()
        );
        reportDataList.add(ReportData.builder()
                .sysChi("三体游戏")
                .sysEng("Three-Body")
                .orgName("ETO")
                .versionLine("2007-07-07")
                .taskFrom("Lord")
                .sysType("APP")
                .taskName("世界属于三体")
                .mainDevLanguage("X")
                .bugId("0000000000001")
                .build()
        );
        return reportDataList;
    }
}
