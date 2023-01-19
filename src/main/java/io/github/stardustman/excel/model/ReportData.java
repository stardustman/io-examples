package io.github.stardustman.excel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * sheet2 对应的列表数据模型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportData {
    private String sysChi;
    private String sysEng;
    private String sysType;
    private String orgName;
    private String mainDevLanguage;
    private String versionLine;
    private String taskName;
    private String taskId;
    private String taskFrom;
    private String bugId;
}
