package io.github.stardustman.excel.model;

import lombok.Builder;
import lombok.Data;

/**
 * sheet0 中对应 漏洞名称（占比前十）
 */
@Data
@Builder
public class BugRankInfo {
    private String bugName;
    private String bugTotal;
    private String bugRatio;
}
