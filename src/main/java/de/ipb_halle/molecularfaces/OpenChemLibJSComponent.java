/*
 * MolecularFaces
 * Copyright 2021 Leibniz-Institut für Pflanzenbiochemie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package de.ipb_halle.molecularfaces;

import javax.faces.component.FacesComponent;

import de.ipb_halle.molecularfaces.resource.AddResourcesListener;

/**
 * This {@link javax.faces.component.UIComponent} renders a chemical structure
 * editor or viewer using the
 * <a href="https://github.com/cheminfo/openchemlib-js">OpenChemLib JS</a>
 * JavaScript plugin.
 * 
 * @author flange
 */
@FacesComponent(OpenChemLibJSComponent.COMPONENT_TYPE)
public class OpenChemLibJSComponent extends MolPluginCore {
	public static final String COMPONENT_TYPE = "molecularfaces.OpenChemLibJS";
	public static final String DEFAULT_RENDERER = OpenChemLibJSRenderer.RENDERER_TYPE;

	/**
	 * Name of the context-param in web.xml that specifies the location of
	 * openchemlib-full.js relative to the application's context root.
	 */
	public static final String WEBXML_CUSTOM_RESOURCE_URL = "de.ipb_halle.molecularfaces.OPENCHEMLIBJS_URL";

	public OpenChemLibJSComponent() {
		super();

		String resourceUrl = getFacesContext().getExternalContext().getInitParameter(WEBXML_CUSTOM_RESOURCE_URL);
		if ((resourceUrl != null) && (!resourceUrl.isEmpty())) {
			AddResourcesListener.addScriptExt(resourceUrl);
		} else {
			AddResourcesListener.addScriptResource("js/openchemlib-full.js");
		}

		setRendererType(DEFAULT_RENDERER);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
}