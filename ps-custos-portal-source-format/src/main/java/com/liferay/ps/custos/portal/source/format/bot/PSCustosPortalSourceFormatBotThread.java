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

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Peter Shin
 */
public class PSCustosPortalSourceFormatBotThread extends Thread {

	@Override
	public void destroy() {
		_destroy = true;

		while (!_destroyed) {
			try {
				if (_log.isInfoEnabled()) {
					_log.info("Waiting for background thread to destroy");
				}

				Thread.sleep(10 * 1000);
			}
			catch (InterruptedException ie) {
				_log.error(ie, ie);
			}
		}

		if (_log.isInfoEnabled()) {
			_log.info("Background thread is destroyed");
		}

		_destroy = false;
		_destroyed = false;
	}

	public void process(String value) {
		_queue.add(value);
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (_destroy) {
					break;
				}

				String queueValue = _queue.poll();

				if (queueValue == null) {
					Thread.sleep(5 * 1000);

					continue;
				}

				try {
					execute(queueValue);
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			catch (Exception e) {
				_log.error("Stopped background thread due to error", e);

				break;
			}
		}

		_destroyed = true;
	}

	protected void execute(String value) throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("#### Execute:" + value + " ####");
		}
	}

	private static final Log _log = LogFactory.getLog(
		PSCustosPortalSourceFormatBotThread.class);

	private boolean _destroy;
	private boolean _destroyed;
	private final Queue<String> _queue = new LinkedBlockingQueue<>();

}