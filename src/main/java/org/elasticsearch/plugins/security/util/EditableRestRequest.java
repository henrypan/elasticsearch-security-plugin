package org.elasticsearch.plugins.security.util;

import java.util.Map;

import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.support.AbstractRestRequest;

public class EditableRestRequest extends AbstractRestRequest {

	private RestRequest innerRestquest = null;
	private BytesReference content = null;
	private Map<String, String> params = null;
	private Method method = null;
	private String uri = null;
	private String rawPath = null;
	private boolean hasContent;
	private boolean contentUnsafe;

	public EditableRestRequest(final RestRequest innerRestquest) {

		this.innerRestquest = innerRestquest;
		this.content = innerRestquest.content();
		this.params = innerRestquest.params();
		this.method = innerRestquest.method();
		this.uri = innerRestquest.uri();
		this.rawPath = innerRestquest.rawPath();
		this.hasContent = innerRestquest.hasContent();
		this.contentUnsafe = innerRestquest.contentUnsafe();

	}

	public void setContent(final BytesReference content) {
		this.content = content;
	}

	public void setParams(final Map<String, String> params) {
		this.params = params;
	}

	public void setMethod(final Method method) {
		this.method = method;
	}

	public void setUri(final String uri) {
		this.uri = uri;
	}

	public void setRawPath(final String rawPath) {
		this.rawPath = rawPath;
	}

	public void setHasContent(final boolean hasContent) {
		this.hasContent = hasContent;
	}

	public void setContentUnsafe(final boolean contentUnsafe) {
		this.contentUnsafe = contentUnsafe;
	}

	public Method method() {
		return this.method;
	}

	public String uri() {
		return this.uri;
	}

	public String rawPath() {

		return this.rawPath;
	}

	public boolean hasContent() {

		return this.hasContent;
	}

	public boolean contentUnsafe() {

		return this.contentUnsafe;
	}

	public BytesReference content() {

		return this.content;
	}

	public String header(final String name) {

		return this.innerRestquest.header(name);
	}

	public boolean hasParam(final String key) {

		return this.params.containsKey(key);
	}

	public String param(final String key) {

		return this.params.get(key);
	}

	public Map<String, String> params() {

		return this.params;
	}

	public String param(final String key, final String defaultValue) {
		final String value = this.params.get(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

}
