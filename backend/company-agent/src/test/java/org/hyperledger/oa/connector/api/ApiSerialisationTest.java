/**
 * Copyright (c) 2020 - for information on the respective copyright owner
 * see the NOTICE file and/or the repository at
 * https://github.com/hyperledger-labs/organizational-agent
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hyperledger.oa.connector.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hyperledger.oa.BaseTest;
import org.hyperledger.oa.client.api.DidDocument;
import org.junit.jupiter.api.Test;

class ApiSerialisationTest extends BaseTest {

    @Test
    void testDidDeserialisation() throws Exception {
        String didDocument = loader.load("files/didDocument.json");
        DidDocument doc = mapper.readValue(didDocument, DidDocument.class);

        assertNotNull(doc);
        assertNotNull(doc.getDidDocument());
        assertNotNull(doc.getDidDocument().getService());
        assertEquals(2, doc.getDidDocument().getService().size());
    }

    @Test
    void testDidEvanDeserialisation() throws Exception {
        String didDocument = loader.load("files/didEvan.json");
        DidDocument doc = mapper.readValue(didDocument, DidDocument.class);

        assertNotNull(doc);
        assertNotNull(doc.getDidDocument());
        assertNotNull(doc.getDidDocument().getService());
        assertEquals(1, doc.getDidDocument().getService().size());
        assertEquals("profile", doc.getDidDocument().getService().get(0).getType());
    }

}
