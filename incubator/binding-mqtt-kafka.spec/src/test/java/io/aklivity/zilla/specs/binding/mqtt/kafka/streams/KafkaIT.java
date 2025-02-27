/*
 * Copyright 2021-2023 Aklivity Inc
 *
 * Licensed under the Aklivity Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 *   https://www.aklivity.io/aklivity-community-license/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.aklivity.zilla.specs.binding.mqtt.kafka.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class KafkaIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("kafka", "io/aklivity/zilla/specs/binding/mqtt/kafka/streams/kafka");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${kafka}/publish.client.sent.abort/client",
        "${kafka}/publish.client.sent.abort/server"})
    public void shouldPublishReceiveClientSentAbort() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.client.sent.reset/client",
        "${kafka}/publish.client.sent.reset/server"})
    public void shouldPublishReceiveClientSentReset() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.server.sent.abort/client",
        "${kafka}/publish.server.sent.abort/server"})
    public void shouldPublishReceiveServerSentAbort() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.server.sent.flush/client",
        "${kafka}/publish.server.sent.flush/server"})
    public void shouldPublishReceiveServerSentFlush() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.server.sent.reset/client",
        "${kafka}/publish.server.sent.reset/server"})
    public void shouldPublishReceiveServerSentReset() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.server.sent.data/client",
        "${kafka}/publish.server.sent.data/server"})
    public void shouldPublishAbortWhenServerSentData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.empty.message/client",
        "${kafka}/publish.empty.message/server"})
    public void shouldSendEmptyMessage() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.one.message/client",
        "${kafka}/publish.one.message/server"})
    public void shouldSendOneMessage() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.multiple.messages/client",
        "${kafka}/publish.multiple.messages/server"})
    public void shouldSendMultipleMessages() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.with.user.properties.distinct/client",
        "${kafka}/publish.with.user.properties.distinct/server"})
    public void shouldSendWithDistinctUserProperties() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.with.user.properties.repeated/client",
        "${kafka}/publish.with.user.properties.repeated/server"})
    public void shouldSendWithRepeatedUserProperties() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/publish.with.user.property/client",
        "${kafka}/publish.with.user.property/server"})
    public void shouldSendWithUserProperty() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.client.sent.abort/client",
        "${kafka}/subscribe.client.sent.abort/server"})
    public void shouldSubscribeReceiveClientSentAbort() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.client.sent.data/client",
        "${kafka}/subscribe.client.sent.data/server"})
    public void shouldSubscribeAbortWhenClientSentData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.client.sent.reset/client",
        "${kafka}/subscribe.client.sent.reset/server"})
    public void shouldSubscribeReceiveClientSentReset() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.server.sent.abort/client",
        "${kafka}/subscribe.server.sent.abort/server"})
    public void shouldSubscribeReceiveServerSentAbort() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.server.sent.flush/client",
        "${kafka}/subscribe.server.sent.flush/server"})
    public void shouldSubscribeReceiveServerSentFlush() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.server.sent.reset/client",
        "${kafka}/subscribe.server.sent.reset/server"})
    public void shouldSubscribeReceiveServerSentReset() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.one.message/client",
        "${kafka}/subscribe.one.message/server"})
    public void shouldReceiveOneMessage() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.one.message.receive.response.topic.and.correlation.data/client",
        "${kafka}/subscribe.one.message.receive.response.topic.and.correlation.data/server"})
    public void shouldReceiveCorrelationData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.one.message.user.properties.unaltered/client",
        "${kafka}/subscribe.one.message.user.properties.unaltered/server"})
    public void shouldReceiveOneMessageWithUserPropertiesUnaltered() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.publish.no.local/client",
        "${kafka}/subscribe.publish.no.local/server"})
    public void shouldNotReceiveLocal() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.receive.message.wildcard/client",
        "${kafka}/subscribe.receive.message.wildcard/server"})
    public void shouldReceiveOneMessageWithPatternTopic() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.receive.message.overlapping.wildcard/client",
        "${kafka}/subscribe.receive.message.overlapping.wildcard/server"})
    public void shouldReceiveMessageOverlappingWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filter.multi.level.wildcard/client",
        "${kafka}/subscribe.topic.filter.multi.level.wildcard/server"})
    public void shouldFilterMultiLevelWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filter.single.level.wildcard/client",
        "${kafka}/subscribe.topic.filter.single.level.wildcard/server"})
    public void shouldFilterSingleLevelWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filter.single.and.multi.level.wildcard/client",
        "${kafka}/subscribe.topic.filter.single.and.multi.level.wildcard/server"})
    public void shouldFilterSingleAndMultiLevelWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filter.two.single.level.wildcard/client",
        "${kafka}/subscribe.topic.filter.two.single.level.wildcard/server"})
    public void shouldFilterTwoSingleLevelWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filters.aggregated.both.exact/client",
        "${kafka}/subscribe.topic.filters.aggregated.both.exact/server"})
    public void shouldFilterAggregatedBothExact() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filters.isolated.both.exact/client",
        "${kafka}/subscribe.topic.filters.isolated.both.exact/server"})
    public void shouldFilterIsolatedBothExact() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filters.overlapping.wildcards/client",
        "${kafka}/subscribe.topic.filters.overlapping.wildcards/server"})
    public void shouldFilterOverlappingWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filters.aggregated.exact.and.wildcard/client",
        "${kafka}/subscribe.topic.filters.aggregated.exact.and.wildcard/server"})
    public void shouldFilterAggregatedExactAndWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/subscribe.topic.filters.isolated.exact.and.wildcard/client",
        "${kafka}/subscribe.topic.filters.isolated.exact.and.wildcard/server"})
    public void shouldFilterIsolatedExactAndWildcard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/unsubscribe.after.subscribe/client",
        "${kafka}/unsubscribe.after.subscribe/server"})
    public void shouldAcknowledge() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${kafka}/unsubscribe.topic.filter.single/client",
        "${kafka}/unsubscribe.topic.filter.single/server"})
    public void shouldAcknowledgeSingleTopicFilter() throws Exception
    {
        k3po.finish();
    }
}
