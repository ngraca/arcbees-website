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

package com.arcbees.website.client.resources;

import com.arcbees.gsss.animation.client.AnimationResources;
import com.google.gwt.resources.client.ImageResource;

public interface PageBeesResources extends FontResources {
    interface Style extends AnimationResources.Animation {
        String bees();

        String slide();

        String slides();

        String prev();

        String next();

        String pager();

        String active();

        String bee();

        String beeHolder1();

        String beeHolder2();

        String bee1();

        String bee2();

        String bee3();

        String hive();

        String intro();

        String icon1();

        String icon2();

        String icon3();

        String icon4();

        String icon5();

        String icon6();

        String popup();

        String popupContent();

        String header();
    }

    @Source("img/bees/christian.jpg")
    ImageResource beeChristian();

    @Source({"com/arcbees/gsss/animation/client/animationsettings.gss",
            "com/arcbees/gsss/animation/client/animations.gss", "com/arcbees/gsss/mixin/client/mixins.gss",
            "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/bees.gss"})
    Style style();
}
