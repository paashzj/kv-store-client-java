package com.github.shoothzj.kv.api.module;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hezhangjian
 */
@Slf4j
@Data
public class
KvGetResult {

    private String content;

    private Exception exception;

}
