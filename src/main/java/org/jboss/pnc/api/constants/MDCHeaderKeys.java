/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014-2020 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.api.constants;

public enum MDCHeaderKeys {

    USER_ID("log-user-id", MDCKeys.USER_ID_KEY),
    REQUEST_CONTEXT("log-request-context", MDCKeys.REQUEST_CONTEXT_KEY),
    PROCESS_CONTEXT("log-process-context", MDCKeys.PROCESS_CONTEXT_KEY),
    TMP("log-tmp", MDCKeys.TMP_KEY),
    EXP("log-exp", MDCKeys.EXP_KEY);

    private final String headerName;
    private final String mdcKey;

    MDCHeaderKeys(String headerName, String mdcKey) {
        this.headerName = headerName;
        this.mdcKey = mdcKey;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getMdcKey() {
        return mdcKey;
    }
}
