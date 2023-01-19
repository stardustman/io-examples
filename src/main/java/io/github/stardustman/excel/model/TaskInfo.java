package io.github.stardustman.excel.model;

import lombok.Builder;
import lombok.Data;

/**
 * sheet0 中对应-任务基本情况
 */
@Data
@Builder
public class TaskInfo {
    private String sysChi;
    private String orgName;
    private String taskName;
    private String sysEng;
    private String sysTypeText;
    private String orgFullName;
    private String mainDevLanguage;
    private String versionLine;
    private String taskCode;
    private String taskFromText;
    private String taskTypeText;
    private String ruleId;
    private String releaseTypeText;
}



