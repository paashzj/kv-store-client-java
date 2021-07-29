package com.github.shoothzj.kv.api;

import com.github.shoothzj.kv.api.module.KvGetResult;

/**
 * @author hezhangjian
 */
public interface IKv {

    void putSync(String group, String key, String value) throws Exception;

    void put(String group, String key, String value, PutCallback putCallback) throws Exception;

    KvGetResult get(String group, String key);

}
