package com.xxl.job.core.handler.impl;

import com.xxl.job.core.handler.IJobHandler;

import java.lang.reflect.Method;

/**
 * @author xuxueli 2019-12-11 21:12:18
 */
public class MethodJobHandler implements IJobHandler {
    private final Object target;
    private final Method method;
    private Method initMethod;
    private Method destroyMethod;

    public MethodJobHandler(Object target, Method method, Method initMethod, Method destroyMethod) {
        this.target = target;
        this.method = method;
        this.initMethod = initMethod;
        this.destroyMethod = destroyMethod;
    }

    @Override
    public void execute() throws Exception {
        method.invoke(target);
    }

    @Override
    public void init() throws Exception {
        if (initMethod != null) {
            initMethod.invoke(target);
        }
    }

    @Override
    public void destroy() throws Exception {
        if (destroyMethod != null) {
            destroyMethod.invoke(target);
        }
    }

    @Override
    public String toString() {
        return "[" + target.getClass() + "#" + method.getName() + "]";
    }
}
