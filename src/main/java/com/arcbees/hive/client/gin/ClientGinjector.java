/*
 * Copyright 2010 ArcBees Inc.
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

package com.arcbees.hive.client.gin;

import com.arcbees.hive.client.resource.Resources;
import com.arcbees.hive.client.application.about.AboutPresenter;
import com.arcbees.hive.client.application.common.AppPresenter;
import com.arcbees.hive.client.application.contact.ContactPresenter;
import com.arcbees.hive.client.application.home.HomePresenter;
import com.arcbees.hive.client.application.home.blog.BlogPresenter;
import com.arcbees.hive.client.application.home.consulting.ConsultingPresenter;
import com.arcbees.hive.client.application.home.development.DevelopmentPresenter;
import com.arcbees.hive.client.application.home.successstory.SuccessStoryPresenter;
import com.arcbees.hive.client.application.jobs.JobsPresenter;
import com.arcbees.hive.client.application.products.ProductsPresenter;
import com.arcbees.hive.client.application.service.ServicePresenter;
import com.arcbees.hive.client.resource.socialmedia.SocialMediaResources;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ClientDispatchModule.class, ClientModule.class})
public interface ClientGinjector extends Ginjector {
    EventBus getEventBus();

    PlaceManager getPlaceManager();

    Resources getResources();

    SocialMediaResources getSocialMediaResources();

    Provider<AppPresenter> getAppPresenter();

    Provider<HomePresenter> getHomePresenter();

    Provider<BlogPresenter> getBlogPresenter();

    Provider<ConsultingPresenter> getConsultingPresenter();

    Provider<DevelopmentPresenter> getDevelopmentPresenter();

    Provider<SuccessStoryPresenter> getSuccessStoryPresenter();

    Provider<ServicePresenter> getServicePresenter();

    Provider<ProductsPresenter> getProductsPresenter();

    Provider<JobsPresenter> getJobsPresenter();

    Provider<AboutPresenter> getAboutPresenter();

    Provider<ContactPresenter> getContactPresenter();
}