/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.oauth2;

import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper;

import javax.inject.Singleton;
import java.util.Optional;

/**
 * Default implementation of {@link ProviderResolver}
 *
 * @author James Kleeh
 * @since 1.2.0
 */
@Singleton
public class DefaultProviderResolver implements ProviderResolver {

    @Override
    public Optional<String> resolveProvider(Authentication authentication) {
        return Optional.ofNullable(authentication.getAttributes().get(OauthUserDetailsMapper.PROVIDER_KEY))
                .map(Object::toString);
    }
}
