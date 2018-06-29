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

import com.liferay.ps.custos.portal.source.format.bot.PSCustosPortalSourceFormatBotTimerTask;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Peter Shin
 */
@Component
public class PSCustosPortalSourceFormatCommandLineRunner
	implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(
			_psCustosPortalSourceFormatBotTimerTask, 5 * 1000, 10 * 1000);
	}

	@Autowired
	private PSCustosPortalSourceFormatBotTimerTask
		_psCustosPortalSourceFormatBotTimerTask;

}