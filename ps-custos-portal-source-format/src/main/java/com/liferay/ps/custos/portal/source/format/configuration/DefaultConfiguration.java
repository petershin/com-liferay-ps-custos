/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.ps.custos.portal.source.format.configuration;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Peter Shin
 */
public class DefaultConfiguration implements Configuration {

	public DefaultConfiguration() {
		Properties properties = new Properties();

		ClassLoader classLoader = Configuration.class.getClassLoader();

		InputStream inputStream = classLoader.getResourceAsStream(
			"ps-custos-portal-source-format.properties");

		if (inputStream != null) {
			try {
				properties.load(inputStream);
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);
			}
		}
		else {
			throw new RuntimeException(
				"Unable to load ps-custos-portal-source-format.properties");
		}

		InputStream extInputStream = classLoader.getResourceAsStream(
			"ps-custos-portal-source-format-ext.properties");

		if (extInputStream != null) {
			try {
				properties.load(extInputStream);
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);
			}
		}

		_properties = properties;
	}

	@Override
	public String getGitHubOAuthToken() {
		return _properties.getProperty("github.oauth.token");
	}

	@Override
	public String getGitHubUser() {
		return _properties.getProperty("github.user");
	}

	private static final Log _log = LogFactory.getLog(
		DefaultConfiguration.class);

	private final Properties _properties;

}