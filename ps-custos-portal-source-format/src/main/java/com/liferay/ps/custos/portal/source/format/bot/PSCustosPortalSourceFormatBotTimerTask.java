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

import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Peter Shin
 */
@Component
public class PSCustosPortalSourceFormatBotTimerTask extends TimerTask {

	@Override
	public void run() {
		try {
			String value = String.valueOf(System.currentTimeMillis());

			_psCustosPortalSourceFormatBot.process(value);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactory.getLog(
		PSCustosPortalSourceFormatBotTimerTask.class);

	@Autowired
	private PSCustosPortalSourceFormatBot _psCustosPortalSourceFormatBot;

}