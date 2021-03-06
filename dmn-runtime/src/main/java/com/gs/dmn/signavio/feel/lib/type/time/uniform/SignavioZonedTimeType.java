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
package com.gs.dmn.signavio.feel.lib.type.time.uniform;

import com.gs.dmn.feel.lib.type.TimeType;
import com.gs.dmn.feel.lib.type.time.uniform.ZonedTimeType;
import org.slf4j.Logger;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import java.time.ZonedDateTime;

public class SignavioZonedTimeType extends ZonedTimeType implements TimeType<ZonedDateTime, Duration> {
    public SignavioZonedTimeType(Logger logger, DatatypeFactory datatypeFactory) {
        super(logger, datatypeFactory);
    }

    @Override
    protected Boolean zonedDateTimeLessThan(ZonedDateTime first, ZonedDateTime second) {
        if (first == null && second == null) {
            return null;
        } else if (first == null) {
            return null;
        } else if (second == null) {
            return null;
        } else {
            int result = compare(first, second);
            return result < 0;
        }
    }

    @Override
    protected Boolean zonedDateTimeGreaterThan(ZonedDateTime first, ZonedDateTime second) {
        if (first == null && second == null) {
            return null;
        } else if (first == null) {
            return null;
        } else if (second == null) {
            return null;
        } else {
            int result = compare(first, second);
            return result > 0;
        }
    }

    @Override
    protected Boolean zonedDateTimeLessEqualThan(ZonedDateTime first, ZonedDateTime second) {
        if (first == null && second == null) {
            return null;
        } else if (first == null) {
            return null;
        } else if (second == null) {
            return null;
        } else {
            int result = compare(first, second);
            return result <= 0;
        }
    }

    @Override
    protected Boolean zonedDateTimeGreaterEqualThan(ZonedDateTime first, ZonedDateTime second) {
        if (first == null && second == null) {
            return null;
        } else if (first == null) {
            return null;
        } else if (second == null) {
            return null;
        } else {
            int result = compare(first, second);
            return result >= 0;
        }
    }
}
