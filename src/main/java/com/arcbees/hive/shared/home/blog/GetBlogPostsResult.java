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

package com.arcbees.hive.shared.home.blog;

import com.gwtplatform.dispatch.shared.Result;

import java.util.List;

/**
 * {@link Result} class for {@link GetBlogPosts}
 * {@link com.gwtplatform.dispatch.shared.Action} that retrieve blog posts from
 * ArcBees's blog.
 * 
 * @author Christian Goudreau
 */
public class GetBlogPostsResult implements Result {
  private List<BlogItem> blogItem;

  @SuppressWarnings("unused")
  private GetBlogPostsResult() {
  }

  public GetBlogPostsResult(final List<BlogItem> blogItem) {
    this.blogItem = blogItem;
  }

  public List<BlogItem> getBlogPosts() {
    return blogItem;
  }
}
