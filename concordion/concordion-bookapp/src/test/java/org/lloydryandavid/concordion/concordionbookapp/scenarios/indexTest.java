package org.lloydryandavid.concordion.concordionbookapp.scenarios;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.runtotals.RunTotalsExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;


@RunWith(ConcordionRunner.class)
@FullOGNL
@Extensions(RunTotalsExtension.class)
public class indexTest {}
