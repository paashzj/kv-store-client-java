package com.github.shoothzj.kv.impl.sqlite;

import com.github.shoothzj.kv.api.IKv;
import com.github.shoothzj.kv.api.PutCallback;
import com.github.shoothzj.kv.api.module.KvGetResult;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Properties;

/**
 * @author hezhangjian
 */
@Slf4j
public class SqliteKvImpl implements IKv {

    private final String folderName;

    private final String db;

    private final String filePath;

    /**
     * 以Sqlite的方式存储，那么文件夹和文件名由用户指定，
     * @param properties
     */
    public SqliteKvImpl(Properties properties) {
        folderName = properties.getProperty(PropConstant.KV_STORE_SQLITE_FOLDER);
        db = properties.getProperty(PropConstant.KV_STORE_SQLITE_DB);
        filePath = folderName + File.pathSeparator + db + ".db";
    }

    @Override
    public void putSync(String group, String key, String value) throws Exception {
        // todo
    }

    @Override
    public void put(String group, String key, String value, PutCallback iPutCallback) {
        // todo
    }

    @Override
    public KvGetResult get(String group, String key) {
        // todo
        return null;
    }


}
