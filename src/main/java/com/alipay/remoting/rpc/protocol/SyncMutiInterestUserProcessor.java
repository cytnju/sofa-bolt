/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.remoting.rpc.protocol;

import com.alipay.remoting.AsyncContext;
import com.alipay.remoting.BizContext;

import java.util.List;

/**
 * Extends this to process user defined request in SYNC way.<br>
 * If you want process reqeuest in ASYNC way, please extends {@link AsynMutiInterestUserProcessor}.
 * @author muyun.cyt
 * @version 2018/6/27 下午2:45
 */
public abstract class SyncMutiInterestUserProcessor<T> extends AbstractMutiInterestUserProcessor<T> {

    /**
     * @see com.alipay.remoting.rpc.protocol.UserProcessor#handleRequest(com.alipay.remoting.BizContext, java.lang.Object)
     */
    @Override
    public abstract Object handleRequest(BizContext bizCtx, T request) throws Exception;

    /**
     * unsupported here!
     *
     * @see com.alipay.remoting.rpc.protocol.UserProcessor#handleRequest(com.alipay.remoting.BizContext, com.alipay.remoting.AsyncContext, java.lang.Object)
     */
    @Override
    public void handleRequest(BizContext bizCtx, AsyncContext asyncCtx, T request) {
        throw new UnsupportedOperationException(
            "ASYNC handle request is unsupported in SyncMutiInterestUserProcessor!");
    }

    /**
     * @see com.alipay.remoting.rpc.protocol.MultiInterestUserProcessor#mutiInterest()
     */
    @Override
    public abstract List<String> mutiInterest();

}
