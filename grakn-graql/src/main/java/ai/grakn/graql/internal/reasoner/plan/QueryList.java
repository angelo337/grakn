/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016-2018 Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Grakn. If not, see <http://www.gnu.org/licenses/gpl.txt>.
 */

package ai.grakn.graql.internal.reasoner.plan;

import ai.grakn.graql.internal.reasoner.query.ReasonerQueryEquivalence;
import ai.grakn.graql.internal.reasoner.query.ReasonerQueryImpl;
import com.google.common.base.Equivalence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * <p>
 * Helper class for lists of {@link ReasonerQueryImpl} queries with equality comparison {@link ReasonerQueryEquivalence}.
 * </p>
 *
 * @author Kasper Piskorski
 *
 */
class QueryList extends QueryCollection<List<ReasonerQueryImpl>, List<Equivalence.Wrapper<ReasonerQueryImpl>>> {

    QueryList(){
        this.collection = new ArrayList<>();
        this.wrappedCollection = new ArrayList<>();
    }

    QueryList(Collection<ReasonerQueryImpl> queries){
        this.collection = new ArrayList<>(queries);
        this.wrappedCollection = queries.stream().map(q -> equality().wrap(q)).collect(Collectors.toList());
    }
}
