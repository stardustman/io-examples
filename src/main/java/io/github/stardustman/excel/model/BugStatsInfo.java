package io.github.stardustman.excel.model;

import lombok.Builder;
import lombok.Data;

/**
 * sheet0 中对应 7-11 行的数据
 */
@Data
@Builder
public class BugStatsInfo {
    private String superTotal;
    private String superRatio;
    private String highTotal;
    private String highRatio;
    private String middleTotal;
    private String middleRatio;
}
