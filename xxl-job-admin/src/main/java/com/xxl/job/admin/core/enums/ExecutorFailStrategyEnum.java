package com.xxl.job.admin.core.enums;

import com.xxl.job.admin.core.util.I18nUtil;

/**
 * Created by xuxueli on 17/5/9.
 */
public enum ExecutorFailStrategyEnum {
     //无失败策略
    NULL(I18nUtil.getString("jobconf_fail_null")),
     //调度失败重试
    FAIL_TRIGGER_RETRY(I18nUtil.getString("jobconf_fail_trigger_retry")),
     //执行失败重试
    FAIL_HANDLE_RETRY(I18nUtil.getString("jobconf_fail_handle_retry"));

    private final String title;
    private ExecutorFailStrategyEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ExecutorFailStrategyEnum match(String name, ExecutorFailStrategyEnum defaultItem) {
        if (name != null) {
            for (ExecutorFailStrategyEnum item: ExecutorFailStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }

}
