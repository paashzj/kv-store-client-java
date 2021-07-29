package com.github.shoothzj.kv.impl.file;

import com.github.shoothzj.javatool.util.StreamUtil;
import com.github.shoothzj.kv.api.IKv;
import com.github.shoothzj.kv.api.PutCallback;
import com.github.shoothzj.kv.api.module.KvGetResult;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hezhangjian
 */
@Slf4j
public class FileKvImpl implements IKv {

    private final String folderName;

    private final File folder;

    public FileKvImpl(Properties properties) {
        this.folderName = properties.getProperty(PropConstant.KV_STORE_FILE_FOLDER);
        folder = new File(folderName);
        if (!folder.exists()) {
            boolean mkdir = folder.mkdir();
            if (!mkdir) {
                throw new RuntimeException("folder create failed.");
            }
        }
    }

    @Override
    public void putSync(String group, String key, String value) throws Exception {
        File file = new File(folderName + "/" + group + ".kv");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                log.error("create file failed ");
                throw new RuntimeException("create file failed");
            }
        }
        Properties prop = new Properties();

        // load a properties file
        prop.load(new FileInputStream(file));
        prop.setProperty(key, value);
        prop.store(new FileOutputStream(file), null);
    }

    @Override
    public void put(String group, String key, String value, PutCallback putCallback) {
        // todo
    }

    @Override
    public KvGetResult get(String group, String key) {
        KvGetResult kvGetResult = new KvGetResult();
        File file = new File(folderName + "/" + group + ".kv");
        FileInputStream input = null;
        try {
            if (!file.exists()) {
                boolean createResult = file.createNewFile();
            }
            Properties prop = new Properties();
            input = new FileInputStream(file);
            // load a properties file
            prop.load(input);
            kvGetResult.setContent(prop.getProperty(key));
        } catch (IOException ex) {
            kvGetResult.setException(ex);
        } finally {
            StreamUtil.close(input);
        }
        return kvGetResult;
    }
}
