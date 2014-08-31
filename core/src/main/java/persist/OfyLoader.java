package com.umi.software.core.persist;
import com.googlecode.objectify.impl.LoaderImpl;
/**
 * Extend the Loader command with our own logic
 *
 * @author Jeff Schnitzer
 */
public class OfyLoader extends LoaderImpl<OfyLoader>
{
	/** */
	public OfyLoader(ObjectDatastore objectDatastore) {
		super(objectDatastore);
	}
}