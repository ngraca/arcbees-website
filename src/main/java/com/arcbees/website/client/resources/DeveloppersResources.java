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

import com.google.gwt.resources.client.GssResource;
import com.google.gwt.resources.client.ImageResource;

public interface DeveloppersResources extends FontResources {
    interface Style extends GssResource {
        String developpers();

        String jukito();

        String breadcrumb();

        String logo();

        String presentation();

        String socialTop();

        String social();

        String frameworkList();

        String slideshow();

        String slides();

        String prev();

        String next();

        String pager();

        String stripeDetails();

        String code();

        String colored();

        String headerBg();

        String gwtp();

        String moreFeatures();

        String chosen();
    }

    @Source("img/developpers/jukitoGuice.png")
    ImageResource jukitoGuice();

    @Source("img/developpers/jukitoJUnit.png")
    ImageResource jukitoJUnit();

    @Source("img/developpers/jukitoMockito.png")
    ImageResource jukitoMockito();

    @Source("img/developpers/gwtpScreen1.png")
    ImageResource gwtpScreen1();

    @Source("img/developpers/gaeScreen2.png")
    ImageResource gaeScreen2();

    @Source("img/developpers/jukitoBanner.png")
    ImageResource jukitoBanner();

    @Source("img/developpers/gwtpBanner.png")
    ImageResource gwtpBanner();

    @Source("img/developpers/chosenBanner.png")
    ImageResource chosenBanner();

    @Source("img/developpers/chosenRelease.jpg")
    ImageResource chosenRelease();

    @Source("img/developpers/chosenSnapshot.jpg")
    ImageResource chosenSnapshot();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/developpers.gss"})
    Style style();
}