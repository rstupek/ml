/*
 Copyright 2012 Joseph B. Ottinger

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.enigmastation.ml.bayes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Feature implements Serializable {
    Object feature;
    Map<Object, Integer> categories = new HashMap<>();

    public Map<Object, Integer> getCategories() {
        return categories;
    }

    public void setCategories(Map<Object, Integer> categories) {
        this.categories = categories;
    }

    public Object getFeature() {
        return feature;
    }

    public void setFeature(Object feature) {
        this.feature = feature;
    }

    public Integer getCountForCategory(Object category) {
        Integer count = categories.get(category);
        if (count == null) {
            return 0;
        }
        return count;
    }

    public void incrementCategoryCount(Object category) {
        Integer oldCount = categories.get(category);
        if (oldCount == null) {
            oldCount = 0;
        }
        categories.put(category, oldCount + 1);
    }
}
