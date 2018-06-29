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

package com.liferay.ps.custos.portal.source.format.rest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peter Shin
 */
@RestController
public class RootRestController {

	@GetMapping("/status")
	public void status() throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("#### Status #####");
		}
	}

	private static final Log _log = LogFactory.getLog(RootRestController.class);

}