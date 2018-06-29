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

package com.liferay.ps.custos.portal.source.format.bot;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @author Peter Shin
 */
@Component
public class PSCustosPortalSourceFormatBot {

	@PreDestroy
	public void destroy() {
		if (_psCustosPortalSourceFormatBotThread != null) {
			_psCustosPortalSourceFormatBotThread.destroy();

			_psCustosPortalSourceFormatBotThread = null;
		}
	}

	@PostConstruct
	public void init() {
		if (_psCustosPortalSourceFormatBotThread == null) {
			_psCustosPortalSourceFormatBotThread =
				new PSCustosPortalSourceFormatBotThread();

			_psCustosPortalSourceFormatBotThread.start();
		}
	}

	public void process(String value) {
		_psCustosPortalSourceFormatBotThread.process(value);
	}

	private PSCustosPortalSourceFormatBotThread
		_psCustosPortalSourceFormatBotThread;

}