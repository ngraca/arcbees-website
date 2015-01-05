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

package com.arcbees.website.client.application.bees;

import com.arcbees.website.client.application.bees.bee.ChristianModule;
import com.arcbees.website.client.application.bees.bee.Christopher.ChristopherModule;
import com.arcbees.website.client.application.bees.bee.Genevieve.GenevieveModule;
import com.arcbees.website.client.application.bees.bee.Jason.JasonModule;
import com.arcbees.website.client.application.bees.bee.Jeanchristophe.JeanchristopheModule;
import com.arcbees.website.client.application.bees.bee.Joel.JoelModule;
import com.arcbees.website.client.application.bees.bee.Julien.JulienModule;
import com.arcbees.website.client.application.bees.bee.Larry.LarryModule;
import com.arcbees.website.client.application.bees.bee.Manon.ManonModule;
import com.arcbees.website.client.application.bees.bee.Maxime.MaximeModule;
import com.arcbees.website.client.application.bees.bee.PhilippeA.PhilippeAModule;
import com.arcbees.website.client.application.bees.bee.PhilippeB.PhilippeBModule;
import com.arcbees.website.client.application.bees.bee.Simonpierre.SimonpierreModule;
import com.arcbees.website.client.application.bees.bee.Francois.FrancoisModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class BeesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ChristianModule());
        install(new FrancoisModule());
        install(new PhilippeBModule());
        install(new GenevieveModule());
        install(new PhilippeAModule());
        install(new JulienModule());
        install(new ManonModule());
        install(new MaximeModule());
        install(new SimonpierreModule());
        install(new ChristopherModule());
        install(new JoelModule());
        install(new JeanchristopheModule());
        install(new JasonModule());
        install(new LarryModule());

        bindPresenter(BeesPresenter.class, BeesPresenter.MyView.class,
                BeesView.class, BeesPresenter.MyProxy.class);

        bind(Konami.class).asEagerSingleton();
    }
}
