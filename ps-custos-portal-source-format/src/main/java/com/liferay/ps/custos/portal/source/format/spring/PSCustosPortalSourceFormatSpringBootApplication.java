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

package com.liferay.ps.custos.portal.source.format.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Peter Shin
 */
@ComponentScan(basePackages = "com.liferay.ps.custos")
@SpringBootApplication
public class PSCustosPortalSourceFormatSpringBootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(
			PSCustosPortalSourceFormatSpringBootApplication.class, args);
	}

}