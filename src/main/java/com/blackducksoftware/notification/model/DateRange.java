/*
 * 
 */
package com.blackducksoftware.notification.model;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class DateRange.
 */
public class DateRange {

	/** The start. */
	private final Date start;

    /** The end. */
    private final Date end;

    /**
     * Instantiates a new date range.
     *
     * @param start the start
     * @param end the end
     */
    public DateRange(final Date start, final Date end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the start.
     *
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * Gets the end.
     *
     * @return the end
     */
    public Date getEnd() {
        return end;
    }
}
