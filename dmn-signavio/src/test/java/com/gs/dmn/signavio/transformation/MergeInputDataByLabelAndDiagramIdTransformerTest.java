/*
 * Copyright 2016 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.gs.dmn.signavio.transformation;

public class MergeInputDataByLabelAndDiagramIdTransformerTest extends AbstractMergeInputDataTransformerTest {
    @Override
    protected AbstractMergeInputDataTransformer getTransformer() {
        return new MergeInputDataByLabelAndDiagramIdTransformer(LOGGER);
    }

    @Override
    protected String getDMNFileName() {
        return "simple-decision-with-bkm-clone-multiple-diagrams.dmn";
    }

    @Override
    protected String getTestLabFileName() {
        return "simple-decision-with-bkm-clone-multiple-diagrams.json";
    }
}