package com.github.shoothzj.kv.api;

/**
 * @author hezhangjian
 */
public interface PutCallback {

    void success(String group, String content);

    void fail(Exception exception);

}
