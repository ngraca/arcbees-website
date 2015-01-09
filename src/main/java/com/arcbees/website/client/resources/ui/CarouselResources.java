/*
 * Copyright 2014 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.website.client.resources.ui;

import com.arcbees.website.client.resources.FontResources;
import com.google.gwt.resources.client.CssResource;

public interface CarouselResources extends FontResources {

    interface Style extends CssResource {
        String carousel();

        String item();

        String items();
    }

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss",
            "com/arcbees/website/client/resources/css/colors.gss",
            "com/arcbees/website/client/resources/fonts/geometria/geometria.gss",
            "com/arcbees/website/client/resources/css/ui/carousel.gss"})
    Style style();
}
