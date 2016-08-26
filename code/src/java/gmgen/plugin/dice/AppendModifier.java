/*
 *  Initiative - A role playing utility to track turns
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package gmgen.plugin.dice;

import java.util.Random;
import java.util.function.Function;
import static org.apache.fop.fonts.type1.AdobeStandardEncoding.z;

public class AppendModifier implements ResultModifier
{

	private final int count;
	private final int max;
	private final Random rand;

	public AppendModifier(final int count, final int max, final Random rand) {
		this.count = count;
		this.max = max;
		this.rand = rand;
	}

	@Override
	public int[] apply(final int[] in)
	{
		int[] newResults = new int[count + in.length];
		System.arraycopy(in, 0, newResults, 0, in.length);
		for (int i = 0; i < count; ++i)
		{
			int thisRoll = rand.nextInt(max) + 1;
			newResults[in.length + i] = thisRoll;
		}

		return newResults;
	}
}
